package itstep.task6.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import itstep.task6.entity.Color;
import javax.persistence.Table;
import javax.persistence.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Data
@Table(name="social_media")
@NoArgsConstructor
public class SocialMedia implements Serializable {

    public SocialMedia(String hue) {
        this.hue = hue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String hue;

    @ManyToMany(mappedBy = "socialMedia", fetch = FetchType.LAZY)
    private List<Color> colors;
}
