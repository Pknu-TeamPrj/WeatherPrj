const city = document.querySelector('#city');
const weather = document.querySelector('#weather');
const temp = document.querySelector('#temp');
const wind = document.querySelector('#wind');
const weatherIconImg = document.querySelector('.weatherIcon');
const feelLikeElem = document.querySelector('#feelLike');
const minTempElem = document.querySelector('#minTemp');
const maxTempElem = document.querySelector('#maxTemp');
const humidityElem = document.querySelector('#humidity');
const outfitSuggestionElem = document.querySelector('#outfitSuggestion');

window.onload = () => {
    const lat = latitude; //위도
    const lon = longitude; //경도
    const lang = 'kr'; //언어
    const units = 'metric'; //섭씨
    console.log(`현재 위도 및 경도 : ${lat}, ${lon} `);
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&lang=${lang}&units=${units}&appid=10f3e82c6d9ff43e765c8586c5a68d90`;
    fetch(url)
        .then(response => response.json())
        .then(async data => {
            const temperature = Math.round(data.main.temp);
            const windDirection = degToCompass(data.wind.deg);
            const feelLike = Math.round(data.main.feels_like);
            const minTemp = Math.round(data.main.temp_min);
            const maxTemp = Math.round(data.main.temp_max);
            const humidity = data.main.humidity;
            const mWeather = data.weather[0].main;
            const weatherIconAdrs = `http://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`;

            // city.innerText = data.name;
            city.innerText = locationName;
            weather.innerText = data.weather[0].description;
            temp.innerText = `${temperature}도`;
            wind.innerText = `${windDirection} ${data.wind.speed}m/s`;
            weatherIconImg.setAttribute('src', weatherIconAdrs);
            feelLikeElem.innerText = `${feelLike}도`;
            minTempElem.innerText = `${minTemp}도`;
            maxTempElem.innerText = `${maxTemp}도`;
            humidityElem.innerText = `${humidity}%`;

            const outfitSuggestion = await getOutfitRecommendation(temperature, data.weather[0].description);
            outfitSuggestionElem.innerText = outfitSuggestion;
        });
}



const degToCompass = (num) => {
    const val = Math.floor((num / 22.5) + 0.5);
    const arr = ['북', '북북동', '동북동', '동동북', '동', '동동남', '남동', '남남동', '남', '남남서', '서남서', '서서남', '서', '서북서', '북서', '북북서'];
    return arr[(val % 16)];
}

const getOutfitRecommendation = async (temperature, weatherDescription) => {
    const prompt = `
    현재 온도는 ${temperature}도이고, 날씨는 ${weatherDescription}입니다.
    이 조건에 맞는 적절한 의상을 추천해주세요.
    `;

    try {
        const response = await fetch('https://api.openai.com/v1/chat/completions', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                // 'Authorization': 'Bearer key값입력'
            },
            body: JSON.stringify({
                model: "gpt-3.5-turbo", // 모델 이름을 지정합니다.
                messages: [{
                    role: "user", // 메시지 역할을 user로 설정
                    content: prompt // 사용자가 입력한 메시지
                }, ],
                max_tokens: 300
            })
        });

        const data = await response.json();
        console.log("OpenAI API 응답:", data); // 응답을 로그로 출력하여 확인
        return data.choices[0].message.content;
    } catch (error) {
        console.error("OpenAI API 호출 오류:", error);
        return "추천을 불러오는 중 오류가 발생했습니다.";
    }
};

const callbackOk = async (position,latitude,longitude) => {
    const lat = position.coords.latitude; //위도
    const lon = position.coords.longitude; //경도
    const lang = 'kr'; //언어
    const units = 'metric'; //섭씨
    console.log(`현재 위도 및 경도 : ${lat}, ${lon} `);
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&lang=${lang}&units=${units}&appid=10f3e82c6d9ff43e765c8586c5a68d90`;
    fetch(url)
        .then(response => response.json())
        .then(async data => {
            const temperature = Math.round(data.main.temp);
            const windDirection = degToCompass(data.wind.deg);
            const feelLike = Math.round(data.main.feels_like);
            const minTemp = Math.round(data.main.temp_min);
            const maxTemp = Math.round(data.main.temp_max);
            const humidity = data.main.humidity;
            const mWeather = data.weather[0].main;
            const weatherIconAdrs = `http://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`;

            // city.innerText = data.name;
            city.innerText = locationName;
            weather.innerText = data.weather[0].description;
            temp.innerText = `${temperature}도`;
            wind.innerText = `${windDirection} ${data.wind.speed}m/s`;
            weatherIconImg.setAttribute('src', weatherIconAdrs);
            feelLikeElem.innerText = `${feelLike}도`;
            minTempElem.innerText = `${minTemp}도`;
            maxTempElem.innerText = `${maxTemp}도`;
            humidityElem.innerText = `${humidity}%`;

            const outfitSuggestion = await getOutfitRecommendation(temperature, data.weather[0].description);
            outfitSuggestionElem.innerText = outfitSuggestion;
        });
}

const callbackError = () => {
    alert("위치정보를 찾을 수 없습니다.");
}

// // 사용자의 현재 위치정보를 가져옴
// navigator.geolocation.getCurrentPosition(callbackOk, callbackError);



