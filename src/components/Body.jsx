
        const weas= ["NWS: DUST STORM WARNING till 10:55PM PDT. Be ready for a sudden drop to zero visibility.",
        "National Weather Service: DUST STORM WARNING for this area until 11:15AM MST. Be ready for sudden drop to zero visibility. Pull Aside, Stay Alive! When visibility drops, pull far off the road and put your vehicle in park. Turn the lights off and keep your foot off the brake. Infants, the elderly and those with respiratory issues urged to take precautions.",
        "NWS: EXTREME WIND WARNING this area til 11:35PM EDT. Take shelter now.",
        "National Weather Service: An EXTREME WIND WARNING is in effect for this area for the immediate danger of life-threatening winds til 11:35PM EDT. Take cover NOW in an interior room of a sturdy building, away from windows. Protect your head from flying debris. Do NOT go out in the calm of the hurricane eye! Winds will quickly become dangerous again.",
         "NWS: FLASH FLOOD WARNING this area til 11:00AM CST. Avoid flooded areas.",
         "National Weather Service: A FLASH FLOOD WARNING is in effect for this area until 6:00AM EDT. This is a dangerous and life-threatening situation. Do not attempt to travel unless you are fleeing an area subject to flooding or under an evacuation order.",

        ]
        const weaspanish= ["SNM: AVISO DE TORMENTA DE POLVO hasta las 10:55PM MST. Espere reduccion de visibilidad.",
                        "AVISO DE TORMENTA DE POLVO hasta las 11:15AM MST. Estar alerta para una reduccion repentina en visibilidad. Cuando la visibilidad disminuya, mueva su vehiculo fuera de la carretera. Apague las luces y mantenga su pie fuera del freno. Se recomienda enfaticamente el tomar precauciones para los infantes, ancianos y personas con problemas respiratorios.",
                        " SNM: AVISO DE VIENTOS EXTREMOS hasta las 11:35PM EDT. Busque refugio ahora.",
                        "Servicio Nacional de Meteorologia: AVISO DE VIENTO EXTREMO en efecto para esta area por peligro inmediato de viento que amenaza vida hasta las 11:35PM EDT. Moverse INMEDIATAMENTE al interior del edificio, alejado de ventanas. Proteja su cabeza de proyectiles. NO salga en la calma del ojo del huracan. El viento se tornara peligroso rapidamente.",
                        "SNM: AVISO DE INUNDACIONES REPENTINAS hasta 11:00AM CST. Evite areas inundadas.",
                        "Servicio Nacional de Meteorologia: AVISO DE INUNDACIONES REPENTINAS en efecto para esta area hasta las 6:00AM EDT. Esta es una situacion peligrosa y amenaza la vida. No intente viajar a menos que sea para abandonar un area propensa a inundaciones o bajo una orden de desalojo.",
        ]
        let data = require('./sample.json');

const Body = () => {

    return (
    <div >
        <div className="column">
            <button className="button-1" onClick={WEAMessage}>Wea Message</button>
            <div id="alert1" className="wea-alert"></div>
            <button className="button-1" onClick={WEASpanish}>Wea Spanish</button>
            <div id="alert2" className="wea-alert"></div>
            <button className="button-1" onClick={fetchJSON}>Display Data</button>
            <div id="alert3" className="wea-alert">
            <table id="table1">
                        {data.map((usr) => {
                            return(
                            <tr>
                                <td>{usr.username}</td>
                                <td>{usr.received}</td>
                                <td>{usr.latency}</td>
                            </tr>
                            )
                        })}
            </table>
            </div>

        </div>

    </div>
    )
}
var count=0;

function WEAMessage(){

    if(count % 2 === 0) {

    var randomNumber=Math.floor(Math.random()*(6))
    document.getElementById("alert1").innerHTML=weas[randomNumber]
    }else{
    var randomNumber2=Math.floor(Math.random()*(6))
    document.getElementById("alert1").innerHTML=weas[randomNumber2]    
    }
    count++        
}
var count2=0;
function WEASpanish(){

    if(count2 % 2 === 0) {
    var randomNumber=Math.floor(Math.random()*(6))
    document.getElementById("alert2").innerHTML=weaspanish[randomNumber]
    }else{
    var randomNumber2=Math.floor(Math.random()*(6))
    document.getElementById("alert2").innerHTML=weaspanish[randomNumber2]
    }
    count2++        
}
let string1= ""
const array1=[]
function fetchJSON(){

console.log(data[0].username)

for (let i = 0; i < data.length; i++) {
    string1= "Username:"+data[i].username+"Alert Received:"+data[i].received
    array1.push(string1)
}
document.getElementById('alert3').innerHTML= array1

} 






export default Body;
