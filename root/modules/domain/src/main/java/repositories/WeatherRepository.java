package root.modules.domain.repositories;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    // 추가적인 메서드가 필요하다면 여기에 선언합니다.
	WeatherEntity findByNxAndNy(int nx, int ny);
}
