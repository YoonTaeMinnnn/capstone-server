package login.jwtlogin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Restaurant {

    @Id @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    private String name;

    private String category;

    private String address;

    private double longtitude;   //경도

    private double latitude;    //위도

    @Builder
    public Restaurant(String name) {
        this.name = name;
    }

}
