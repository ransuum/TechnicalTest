package mathHelper.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "equals")
public class Examples {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String example;
    private double equal;

    public void setExample(String example) {
        this.example = example;
    }

    public void setEqual(double equal) {
        this.equal = equal;
    }

    @Override
    public String toString() {
        return "Examples{" +
                "id=" + id +
                ", example='" + example + '\'' +
                ", equal=" + equal +
                '}';
    }
}
