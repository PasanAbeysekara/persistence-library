package com.solution.x.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.solution.x.dao.key.PropMediaID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.*;

/**
 * @author Tharindu Aththanayake
 * @since 09/02/2020 00:35 A.M.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prop_media")
public class PropMedia {

    @EmbeddedId
    private PropMediaID propMediaID;

    @Column(name = "media_name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "path")
    private String path;

    @Column(name = "type")
    private String type;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prop_id", insertable = false, updatable = false)
    @ToString.Exclude
    private Property property;

    @Transient
    private String url;

    public String getURL(){

        return ServletUriComponentsBuilder.fromCurrentContextPath().path( this.path + "/" ).path( this.name ).path( "."+ this.type ).toUriString();

    }
}
