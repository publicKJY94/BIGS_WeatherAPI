package root.modules.internal.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;

@Service
public class WeatherService {
@Autowired
private WeatherRepository weatherRepository;

// 웹에서는 기본생성자를 사용하지만, 안정성을 고려하여 생정자 주입도 고려
//public WeatherService() {;}
//public WeatherService(WeatherRepository weatherRepository) {
//    this.weatherRepository = weatherRepository;
//}
public WeatherEntity save(WeatherEntity weatherEntity) {
//REST API 호출을 위한 URL 설정
    String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    String serviceKey = "AYe0OJDFU%2B0xe1b0zlK9zXFd%2Fxc0WgFnNw7%2FtRcRBvSJDiGYL0e9%2B5MBP5oVcLz0DKpKon%2Fwpfqh5dmWFOTwqg%3D%3D";
    String pageNo = "1";
    String numOfRows = "1000";
    String dataType = "XML";
    String baseDate = "20240501";
    String baseTime = "0600";
    String nx = "55";
    String ny = "127";

//RestTemplate 객체 생성
    RestTemplate restTemplate = new RestTemplate();

//HttpHeaders 설정
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");

//URI 생성 및 파라미터 설정
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("serviceKey", serviceKey)
            .queryParam("pageNo", pageNo)
            .queryParam("numOfRows", numOfRows)
            .queryParam("dataType", dataType)
            .queryParam("base_date", baseDate)
            .queryParam("base_time", baseTime)
            .queryParam("nx", nx)
            .queryParam("ny", ny);

//REST API 호출 및 응답 받기
    ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);

//응답 코드 확인 및 출력
    HttpStatus statusCode = response.getStatusCode();
    System.out.println("Response code: " + statusCode);

//응답 본문 출력
    WeatherEntity responseBody = (WeatherEntity) response.getBody();
    System.out.println(responseBody);
    return weatherRepository.save(responseBody);
}

    public WeatherEntity findByNxAndNy(int nx, int ny) {
        return weatherRepository.findByNxAndNy(nx, ny);
    }
}
