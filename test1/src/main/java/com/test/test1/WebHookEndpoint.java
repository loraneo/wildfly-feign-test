package com.test.test1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;

import feign.Feign;
import feign.jaxrs.JAXRSContract;

@Path("/")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class WebHookEndpoint {

	@POST
	@Path("/webhook")
	public static void main(String webhookPayload) {
		System.out.println(webhookPayload);

		try {
			readKey("id_rsa");
			readKey("id_rsa.pem");
			GitHub githubClient = Feign.builder().contract(new JAXRSContract()).target(GitHub.class,
					"https://api.github.com");
			githubClient.getAccessToken("2312313", "jWT-TOKEN");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void readKey(String key) throws IOException {
		InputStream is = WebHookEndpoint.class.getResourceAsStream("/" + key);
		String value = IOUtils.toString(is, Charset.forName("UTF-8"));
		System.out.println(value);
	}

}
