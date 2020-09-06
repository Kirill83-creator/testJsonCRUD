package ru.basharin.testJsonCRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "json_table", schema = "json_bd")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonObject extends BaseEntity {

    @Type(type = "json")
    @Column(name = "json_obj", columnDefinition = "json")
    private String jsonObject;
}