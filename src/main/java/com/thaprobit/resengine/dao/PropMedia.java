package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.thaprobit.resengine.dao.key.PropMediaID;
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
public class PropMedia
{
	@EmbeddedId
	private PropMediaID propMediaID;

	@Column(name = "media_file")
	private String file;

	@Column(name = "category")
	private String category;

	@Column(name = "path")
	private String path;

	@Column(name = "media_type")
	private String type;

	@Column(name = "media_title")
	private String title;

	@Column(name = "thumbnail")
	private String thumbnail;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property property;

	@Transient
	private String mediaUrl;

	/*public String getURL()
	{

		return ServletUriComponentsBuilder.fromCurrentContextPath().path( this.path + "/" ).path( this.name ).path( "." + this.type ).toUriString();

	}*/

	public String getMediaUrl()
	{

		return this.path + "/" + this.file;

	}
}
