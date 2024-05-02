package root.modules.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/weather")
    public WeatherEntity getWeather(@PathVariable int nx, @PathVariable int ny) {
    	weatherEntity.setNx(nx);
    	weatherEntity.setNy(ny);
        return weatherService.save(weatherEntity);
    }
//    
//    @PostMapping("/weather")
//    public WeatherEntity postWeather(int nx, int ny) {
//    	return weatherService.findByNxAndNy(nx, ny);
//    }

}