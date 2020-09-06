package ru.basharin.testJsonCRUD.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Getter
@Setter
@Entity
@Table(name = "json_table")
public class JsonObject extends BaseEntity {

    @Type(type = "json")
    @Column(columnDefinition = "json_obj")
    private JSONObject jsonObject;
}
