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
public class MenuCategoryID implements Serializable {
    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "cat_id")
    private Short categoryId;
}
