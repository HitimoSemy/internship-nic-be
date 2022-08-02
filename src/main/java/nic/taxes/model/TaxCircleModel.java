package nic.taxes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nic.taxes.entity.District;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxCircleModel {

	private Integer circleId;

	private String circleName;

	private District district;
}
