window.onload = () =>{
    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition((position) =>{
            //위도
            const latitude = position.coords.latitude;
            //경도
            const longitude = position.coords.longitude;
            let mapDiv = document.getElementById('map');
            naverMap(latitude,longitude);


            
        });
    //navigator가 없다면
    }else{
        notFoundGeoLocation();
    }

};


//네이버 API를 통한 지도 출력
function naverMap(latitude,longitude){
    let infowindow = new naver.maps.InfoWindow();
    let map = new naver.maps.Map('map',{
        center : new naver.maps.LatLng(latitude, longitude),
        zoom:13,
        mapTypeId : naver.maps.MapTypeId.NORMAL
    })

    let location = new naver.maps.LatLng(latitude,longitude);
    infowindow.setContent('<div style="padding:20px;">' + '사용자의 위치' + '</div>');
    infowindow.open(map,location);
    

    message(location);
    
}

//주소 출력하기
function message(location){
    if (typeof naver === 'undefined' || typeof naver.maps === 'undefined' || typeof naver.maps.Service === 'undefined') {
        console.error('네이버 지도 API가 로드되지 않았습니다.');
        return;
    }
    const latlng = location;
    naver.maps.Service.reverseGeocode({
        coords : latlng,
        order : naver.maps.Service.OrderType.ROAD_ADDR
    },function(status,response){
        if(status == naver.maps.Service.Status.Error){
            return alert('오류가 발생했습니다. 관리자에게 문의해주세요!');
        }
        let items = response.v2.results;
        let region = items[0].region;
        

            //주소출력하기
        let messageDiv = document.getElementById('message');
        console.log(region);
        const area2 = region.area3.name;

        messageDiv.textContent = area2;
    })
}

// 사용자의 위치를 찾지 못 했을 때 나올 지도
function notFoundGeoLocation() {
    let infowindow = new naver.maps.InfoWindow();
    let map = new naver.maps.Map('map',{
        center:new naver.maps.LatLng(37.5666805, 126.9784147),
        zoom:10,
        mapTypeId:naver.maps.MapTypeId.NORMAL
    });
    let center = map.getCenter();
    console.log(11);
    infowindow.setContent('<div style="padding:20px;">' +
    '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');
    infowindow.open(map, center);
}