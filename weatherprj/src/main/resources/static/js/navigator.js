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
    document.getElementById('search').addEventListener('click', () => {
            const location = document.getElementById('location-input').value;
            searchLocation(location);
            });
};

//네이버 API를 통한 지도 출력
function naverMap(latitude,longitude){
    let infowindow = new naver.maps.InfoWindow();
    let map = new naver.maps.Map('map',{
        center : new naver.maps.LatLng(latitude, longitude),
        zoom:16,
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

// 사용자가 직접 입력한 위치에 나올 지도
function searchLocation(locationName) {
    naver.maps.Service.geocode({
        query: locationName
    }, function(status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            return alert('오류가 발생했습니다. 관리자에게 문의해주세요!');
        }
        
        if (response.v2.addresses.length === 0) {
            return alert('주소를 찾을 수 없습니다.');
        }

        let item = response.v2.addresses[0];
        let latitude = item.y;
        let longitude = item.x;

        naverMap(latitude, longitude);
    });
}

// 아니요 버튼 눌렀을시 location-input-group 출력
function showContent() {
    var content = document.getElementById("location-input");
    var content1 = document.getElementById("search");
    if (content.style.display === "none" && content1.style.display ==="none") {
        content.style.display = "block"; // 내용 보이기
        content1.style.display = "block";
    }
}