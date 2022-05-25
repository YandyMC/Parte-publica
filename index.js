//npm i inquirer
//repositorio de los ejemplos
//https://github.com/SBoudrias/Inquirer.js/blob/master/packages/inquirer/examples/recursive.js
//video de referencia: https://www.youtube.com/watch?v=zPDqcOxwovA&list=PLCKuOXG0bPi2HgUouLZ0NMmvXrW4zYD7y&index=5
//pagina con documentacion: https://www.npmjs.com/package/inquirer
//libreria util: https://ourcodeworld.co/articulos/leer/298/como-mostrar-mensajes-coloridos-en-la-consola-en-nodejs


const inquirer = require('inquirer');
//pregunta para diferenciar usuarios
const TipoUsuario = [
    {
        type: 'list',
        name: 'Usuario',
        message: 'Que tipo de usuario eres',
        choices: ['Cliente', 'Representante de Taller','Salir']
    }
]

const Voler=[
    {
        type:'list',
        name: 'Volver',
        choices: ['Volver']
    }
]

const Cerrarv =[
    {
        type:'list',
        name: 'VolverC',
        choices: ['Volver','Cerrar']   
    }
] 

// preguntas para el usuario cliente
const VistaTaller = [
    {
        type: 'list',
        name: 'VerTaller',
        message: 'Que desea hacer',
        choices: ['Ver Talleres Disponibles','Revisar agendamiento' ,'Volver','Salir']
    }
]

const Agenda = [
    {
        type: 'imput',
        name: 'Cedula',
        mesage: 'Ingrese su numero de cedula'
    }
]
const CitasD = [
    {
        type: 'list',
        name: 'listado',
        choices: ['Cita1','Cita2','Cita3','Cita4','','Volver','Salir']
    }
]
const ListaTallers = [
    {
        type: 'list',
        name: 'VerTaller',
        message: 'escoga al taller al que desea ingresar',
        choices: ['Taller1', 'Taller2','Taller3','Taller4','','Volver','Salir']
    }
]

const Cita = [
    {
        type: 'list',
        name: 'CitaI',
        choices: ['Si','No']

    }
]
const RegistrarCita = [
    {
        type:'imput',
        name: 'Nombre',
        message: 'Nombre del usuario:'
    },
    {
        type:'imput',
        name: 'Cedula',
        message: 'Numero de cedula:'
    },
    {
        type:'imput',
        name: 'Telefono',
        message: 'Numero de telefono:'
    }
]
const DatosVehiculo = [
        {
            type:'imput',
            name: 'Placa',
            message: 'Placa del vehiculo'
        },
        {
            type:'imput',
            name: 'Marca',
            message: 'Marca del vehiculo:',
            default: 'Desconocida'
        },
        {
            type:'imput',
            name: 'Color',
            message: 'Color del vehiculo',
            default: 'color desconocido'
        },
        {
            type:'imput',
            name: 'Modelo',
            message: 'Modelo del vehiculo'
        }
]

//preguntas para el usuario representante
const CTaller = [
    {
        type:'imput',
        name: 'NombreT',
        message: 'Nombre del Taller: '
    },
    {
        type:'imput',
        name: 'Direccion',
        message: 'Direccion del taller: ',
    },
    {
        type:'imput',
        name: 'TelefonoT',
        message: 'Telefono del taller: ',
    },
    {
        type:'imput',
        name: 'Representante',
        message: 'Nombre del representante del taller: '
    }
]
const ServiciosT = [
    {
        type: 'input',
        name: 'Servicio',
        message: "Servicio del taller: ",
      },
      {
        type: 'confirm',
        name: 'ServicioN',
        message: 'Desea ingresar otro servicio al taller?',
        default: true,
      },
]
const output = [];

const OptTaller = [
    {
        type: 'list',
        name: 'Opciones',
        choices: ['Crear Taller','Ver taller','Volver','Salir']
    }
]

const IngreseTaller =[
    {
        type: 'imput',
        name: 'BuscarTaller',
        message: 'Ingrese el nombre del taller que desea buscar'
    }
]
const VerT=[
    {
        type: 'list',
        name: 'Vertalleres',
        choices: ['Editar Taller', 'Ver Citas','','Volver','Salir']
    }
]

const VerC = [
    {
        type: 'list',
        name: 'VerCitas',
        choices: ['Cita1', 'Cita2', 'Cita3'] 
    }
]

const Edit = [
    {
        type: 'list',
        name: 'EditT',
        choices: ['Nombre', 'Direccion', 'Telefono','Representante','Servicios','Terminar','Salir'] 
    }
]



function main() {
    console.log('Servicio de reserva de Citas en un Taller');
    IdentificaUsuario();
  }

  function IdentificaUsuario() {
    inquirer.prompt(TipoUsuario).then((answers) => {
      if (answers.Usuario === 'Cliente') {
        console.log('Usuario identificado como Cliente');
        VerTalleres();
      }else{
        if(answers.Usuario == 'Representante de Taller'){
            console.log('Usuario identificado como Representante de Taller');
            OptcionesRepresentante();
          }else {
            console.log('Saliendo...');
            return 0;   
         }
      }
    });
  }

  function VerTalleres() {
    inquirer.prompt(VistaTaller).then((answers) => {
      if (answers.VerTaller === 'Ver Talleres Disponibles') {
        console.log('Viento talleres disponibles');
        ListaTaller();
      }
      else{
          if (answers.VerTaller === 'Revisar agendamiento') {
            console.log('Busqueda de citas disponibles');
            Agendamiento();
          }
          else{
            if (answers.VerTaller === 'Volver') {
                console.log('Volviendo...');
                main(); 
          }
          else {
            console.log('Saliendo...');
            return 0;
            }
        }
        }
    });
  }


  function Agendamiento(){
    inquirer.prompt(Agenda).then((answers)=>{
        console.log(`Citas disponibles para el usuario:`)
        inquirer.prompt(CitasD).then((answers)=>{
            if(answers.listado=== 'Volver'){
                console.log('Volviendo...');
                VerTalleres();
            }else{
                if(answers.listado === 'Salir'){
                    console.log('Saliendo...');
                    return 0;
                }else{
                    console.log(`Datos del taller:`, answers);
                    console.log(`datos de la cita`);
                    inquirer.prompt(Cita).then((answers)=>{
                        console.log(`Desea eliminar la cita?`);
                        if (answers.CitaI === 'Si') {
                            console.log(`Cita eliminada`)
                            Agendamiento();
                          } else {
                            console.log('Volviendo a citas disponibles');
                            Agendamiento();
                          }
                    });       
                }
            }
        });
    })
  }

  function ListaTaller() {
    inquirer.prompt(ListaTallers).then((answers) => {
        if(answers.VerTaller === 'Volver'){
            console.log('Volviendo...');
            VerTalleres();
        }else{
            if(answers.VerTaller === 'Salir'){
                console.log('Saliendo...');
                return 0;
            }else{
                console.log(`Datos del taller:`, answers);
                console.log(`telefono, dirreccion, servicios`);
                inquirer.prompt(Cita).then((answers)=>{
                    console.log(`Desea agendar una cita con este taller`);
                    if (answers.CitaI === 'Si') {
                        PosibleCita();
                      } else {
                        console.log('Volviendo a talleres disponibles');
                        ListaTaller();
                      }
                })  
            }
        }
    })   
  }

  function PosibleCita() {
    inquirer.prompt(RegistrarCita).then((urs) => {
        //validar datos
        console.log(`Rellene datos de su vehiculo`);
        inquirer.prompt(DatosVehiculo).then((answers)=>{
            console.log('se ha registrado una cita para:\n ',urs);
            console.log('con el vehiculo:\n ',answers);
        })
    });
  }

  function OptcionesRepresentante() {
    inquirer.prompt(OptTaller).then((answers) => {
        if (answers.Opciones === 'Crear Taller') {
            CrearTaller();
          }
        else{
            if(answers.Opciones === 'Ver taller'){
                VerTaller();
            }else{
                if(answers.Opciones === 'Volver'){
                    console.log('Volviendo...');
                    IdentificaUsuario();
                }else{
                    console.log('Saliendo...');
                    return 0;
                }
            }    
        }
    });
  }

  function CrearTaller(){
    inquirer.prompt(CTaller).then((TallerN)=>{
    console.log('El taller ha sido creado con los datos .....')
    ServiciosTaller()
    })
  }

  function ServiciosTaller(){
    inquirer.prompt(ServiciosT).then((answers)=>{
        output.push(answers.Servicio);
        if (answers.ServicioN) {
          ServiciosTaller();
        } else {  
          console.log('Los servicion del Taler son:', output.join(', '));
          OptcionesRepresentante()
        }
    })
  }

  function ServiciosTaller2(){
    inquirer.prompt(ServiciosT).then((answers)=>{
        output.push(answers.Servicio);
        if (answers.ServicioN) {
            ServiciosTaller2();
        } else {  
          console.log('Los servicion del Taler son:', output.join(', '));
          ElegirEdit();
        }
    })
  }

  function VerTaller(){
      inquirer.prompt(IngreseTaller).then((answers)=>{
          console.log('datos del taller', answers)
          inquirer.prompt(VerT).then((answers)=>{
            if (answers.Vertalleres === 'Editar Taller') {
                console.log('opciones para editar el taller')
                ElegirEdit();
              }else{
                if (answers.Vertalleres === 'Ver Citas'){
                    inquirer.prompt(VerC).then((answers)=>{
                        console.log('datos de la cita' ,answers);
                        console.log('datos especificos')
                    })
                }else{
                    if (answers.Vertalleres === 'Volver'){
                        console.log('Volviendo...');
                        OptcionesRepresentante();  
                    }else{
                        console.log('Saliendo...');
                        return 0;
                    }
                }
              }

          })

      })
  }
  
  function ElegirEdit(){
    inquirer.prompt(Edit).then((answers)=>{
        if(answers.EditT === 'Nombre'){
            inquirer.prompt(CTaller[0]).then((answers)=>{
                ElegirEdit();    
            })
        }else{
            if(answers.EditT === 'Direccion'){
                inquirer.prompt(CTaller[1]).then((answers)=>{ 
                    ElegirEdit();  
                })
            }else{
                if(answers.EditT === 'Telefono'){
                    inquirer.prompt(CTaller[2]).then((answers)=>{
                        ElegirEdit();   
                    })
                }else{
                    if(answers.EditT === 'Representante'){
                        inquirer.prompt(CTaller[3]).then((answers)=>{ 
                            ElegirEdit();  
                        })
                    }else{
                        if(answers.EditT === 'Servicios'){
                            ServiciosTaller2();
                    }else{
                        if(answers.EditT === 'Terminar'){
                            console.log(`Datos cambiados`);
                            console.log(`Mostrar datos de taller ahora`);
                            OptcionesRepresentante()
                        }else{
                            console.log(`No se edito el taller`);
                            OptcionesRepresentante()
                        }
                    } 
                    }
                }
            }
        }
    })
  }

  main();