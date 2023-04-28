-- clase 1
select * from sys.tables --selecciona toda la cantidad de tablas

-- clase 2
select * from Employees
select numeroderegisto =  COUNT(*) from Employees -- solamente crea un campo y pone la cantidad de registro
Select numeroderegistro = COUNT(*), campo = 'Dim_cargos ' From [Dim_cargos] -- Se uso excel para concatenar y hacerlo mas rapido con otras tablas &

-- clase 3
select * from Customers
select DISTINCT(ContactTitle) from Customers -- sin el distinct hace que se vean los repetidos

create table Dim_cargos(
	idCargo int Primary key,
	cargo char(10)
) -- crea una tabla con sus campos
alter table Dim_cargos alter column cargo VarChar(50) -- modifica el tipo de columna

-- hace una migracion de datos de la tabla customers a la tabla dim_cargos
insert into Dim_cargos (idCargo, cargo) -- inserta en el campo idCargo y cargo
select idCargo = ROW_NUMBER() over (order by cargo),-- ingresa datos al id cargo un numero cresiente
cargo from(select distinct cargo=ContactTitle from Customers) as prueba  -- ingresa los datos delimitaos como T_cargos
-- fin de la migracion
exec eliminar_tabla 

select * from Dim_cargos;

CREATE PROCEDURE eliminar_tabla AS begin --procedimiento para eliminar la tabla
truncate table Dim_Cargos -- instruccion que seguira el procedimiento
END

exec eliminar_tabla




CREATE PROCEDURE migrar_datos as begin --procedimiento para llenar otra vez la tabla

insert into Dim_cargos(IdCargo,Cargo)
select IdCargo=ROW_NUMBER()over (order by Cargo),
Cargo
from (select distinct
Cargo=ContactTitle
from Northwind.dbo.Customers
)as T_Cargos
order by Cargo

end

exec migrar_datos





