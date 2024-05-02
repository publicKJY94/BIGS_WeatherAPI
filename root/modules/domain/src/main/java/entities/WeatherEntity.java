package root.modules.domain.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class WeatherEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 결과코드
    private String resultCode;

    // 결과메시지
    private String resultMsg;

    // 한 페이지 결과 수
    private Integer numOfRows;

    // 페이지 번호
    private Integer pageNo;

    // 전체 결과 수
    private Integer totalCount;

    // 데이터 타입
    private String dataType;

    // 발표일자
    private String baseDate;

    // 발표시각
    private String baseTime;

    // 예보지점 X 좌표
    private Integer nx;

    // 예보지점 Y 좌표
    private Integer ny;

    // 자료구분코드
    private String category;

    // 실황 값
    private Double obsrValue;
}
