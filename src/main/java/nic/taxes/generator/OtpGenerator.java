package nic.taxes.generator;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpGenerator {

	public int generateOTP() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return otp;
	}
}
