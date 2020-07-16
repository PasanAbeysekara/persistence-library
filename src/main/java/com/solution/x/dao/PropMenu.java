package com.solution.x.dao;

import com.solution.x.dao.key.MenuChoiceID;
import com.solution.x.dao.key.PropMenuID;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Tharindu Aththanayake
 */
@Data
@Entity
@Table(name = "prop_menu")
@ToString
public class PropMenu
{
    @EmbeddedId
    @ToString.Include
    private PropMenuID propMenuID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("prop_id")
    @JoinColumn(name = "prop_id")
    @ToString.Exclude
    private Property property;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("menu_id")
    @JoinColumn(name = "menu_id")
    @ToString.Exclude
    private Menu menu;
}
