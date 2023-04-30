package itstep.task6.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Entity;
import itstep.task6.entity.Shade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@Table(name="color")
@NoArgsConstructor
public class Color implements Serializable {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_social_media",
            joinColumns = @JoinColumn(name = "color_id"),
            inverseJoinColumns = @JoinColumn(name = "social_media_id"))
    private List<SocialMedia> socialMedia;
    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Device> devices;


    public Color(Shade shade) {
        this.shade = shade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private List<String> colors;
    @Column
    private boolean primary;
    @Column
    private Map<String,Integer> rgb = new HashMap<String,Integer>();

    @OneToOne(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Shade shade;

    public Color(List<String> colors, boolean primary, Map<String, Integer> rgb) {
        this.colors = colors;
        this.primary = primary;
        this.rgb = rgb;
    }

    public Color(List<String> colors, boolean primary) {
        this.colors = colors;
        this.primary = primary;
    }

    public void setRgb(Map<String, Integer> rgb) {
        this.rgb = rgb;
    }
}