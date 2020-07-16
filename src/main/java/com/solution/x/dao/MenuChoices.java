package com.solution.x.dao;

import com.solution.x.dao.key.MenuChoiceID;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Tharindu Aththanayake
 */
@Data
@Entity
@Table(name = "menu_choices")
@ToString
public class MenuChoices
{
    @EmbeddedId
    @ToString.Include
    private MenuChoiceID menuChoiceID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "cat_id", referencedColumnName = "cat_id", updatable = false, insertable = false),
            @JoinColumn(name = "menu_id", referencedColumnName = "menu_id", updatable = false, insertable = false)
    })
    @ToString.Exclude
    private MenuCategory choiceMenuCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("menu_id")
    @JoinColumn(name = "menu_id")
    @ToString.Exclude
    private Menu choiceMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("prop_ch_id")
    @JoinColumn(name = "prop_ch_id")
    @ToString.Exclude
    private PropChoices propChoice;
}
