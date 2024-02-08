db.Empleado.aggregate(
{$group:{_id:null, EdadPromedio:{$avg:"$Edad"}}}).toArray()

db.Empleado.aggregate([
    {$group:{_id:"$Carrera", Edad_Promedio:{$avg:"$Edad"}}},
    {$match:{Edad_Promedio:{$gte:y[0].EdadPromedio}}},
    {$sort:{Edad_Promedio: 1}}
])


db.Empleado.aggregate([
    {$group:{_id:"$Carrera", Cantidad_Mujeres:{$count:"$Sexo":{$eq: 'F'}}},
])


db.Empleado.aggregate([
    {$group:{_id:"$Carrera", Cantidad_Mujeres:{$count:{}}}},
    {$match: {Cantidad_Mujeres:{$eq: 'F'}}}
])