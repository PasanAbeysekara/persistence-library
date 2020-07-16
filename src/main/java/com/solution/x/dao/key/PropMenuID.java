package com.solution.x.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PropMenuID implements Serializable
{
    @Column(name = "prop_id")
    private Long propId;

    @Column(name = "menu_id")
    private Long menuId;
}
