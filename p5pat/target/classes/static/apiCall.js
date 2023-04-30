
window.addEventListener('load', getDailyIMG);

var requestOptions = {
    method: 'GET',
};

//"https://api.nasa.gov/planetary/apod?api_key=jhGISIlXsL9Xw2d93pdklkpvOc9TUKjPJGyTaB6M"

async function getDailyIMG() {
    const url = '/dailyIMG';

    var res = await fetch(url,requestOptions)
        .then(response => response.json())
        .then(result => {

            console.log(result)
            showData(result)})

        .catch(e => {
            console.log('error', e);
        })
}

async function showData({explanation, media_type, title, url}) {

    const h3 = document.querySelector("#imgTitle");
    const p = document.querySelector("#desc");
    const aimghd = document.querySelector("#imgHD");

    var titulo = document.createTextNode(title);
    var desc = document.createTextNode(explanation);

    if (media_type == 'video') {
        
        const h1 = document.querySelector("b");
        h1.innerHTML = "Video del día";
        document.body.style.backgroundColor = "black";
        aimghd.innerHTML = "Click para ver el video";

    } else {

        const img = "url('" + url + "')"; //versión hd: hdurl (tarda más en cargar)
        document.body.style.backgroundImage = img;

    }
        
    h3.appendChild(titulo);
    p.appendChild(desc);
    aimghd.href = url;

}