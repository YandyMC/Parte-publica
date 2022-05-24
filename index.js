//npm i inquirer
//repositorio de los ejemplos
//https://github.com/SBoudrias/Inquirer.js/blob/master/packages/inquirer/examples/recursive.js
//video de referencia: https://www.youtube.com/watch?v=zPDqcOxwovA&list=PLCKuOXG0bPi2HgUouLZ0NMmvXrW4zYD7y&index=5
//pagina con documentacion: https://www.npmjs.com/package/inquirer


const inquirer = require('inquirer');
//pregunta para diferenciar usuarios
const TipoUsuario = [
    {
        type: 'list',
        name: 'Usuario',
        message: 'Que tipo de usuario eres',
        choices: ['Cliente', 'Representante de Taller']
    }
]

// preguntas para el usuario cliente
const VistaTaller = [
    {
        type: 'list',
        name: 'VerTaller',
        message: 'Que desea hacer',
        choices: ['Ver Talleres Disponibles','Revisar agendamiento' ,'Salir']
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
        choices: ['Cita1','Cita2','Cita3','Cita4']
    }
]
const ListaTallers = [
    {
        type: 'list',
        name: 'VerTaller',
        message: 'escoga al taller al que desea ingresar',
        choices: ['Taller1', 'Taller2','Taller3','Taller4']
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
        choices: ['Crear Taller','Ver taller']
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
        choices: ['Editar Taller', 'Ver Citas']
    }
]

const VerC = [
    {
        type: 'list',
        name: 'VerCitas',
        choices: ['Cita1', 'Cita2', 'Cita3'] 
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
      } else {
        console.log('Usuario identificado como Representante de Taller');
        OptcionesRepresentante();
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
          else {
            console.log('Volviendo al inicio...');
            main();
            }
        }
    });
  }


  function Agendamiento(){
    inquirer.prompt(Agenda).then((answers)=>{
        console.log(`Citas disponibles para el usuario:`)
        inquirer.prompt(CitasD).then((answers)=>{
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
            })
            
        })
    })
  }

  function ListaTaller() {
    inquirer.prompt(ListaTallers).then((answers) => {
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
            VerTaller();
            }
    });
  }

  function CrearTaller(){
    inquirer.prompt(CTaller).then((TallerN)=>{
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
        }
    })
  }

  function VerTaller(){
      inquirer.prompt(IngreseTaller).then((answers)=>{
          console.log('datos del taller', answers)
          inquirer.prompt(VerT).then((answers)=>{
            if (answers.Opciones === 'Editar Taller') {
                console.log('opciones para editar el taller')
              }
              else{
                inquirer.prompt(VerC).then((answers)=>{
                    console.log('datos de la cita' ,answers);
                    console.log('datos especificos')
                })
                }
          })

      })
  }
  
main();
