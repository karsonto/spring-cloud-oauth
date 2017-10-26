package com.karson.webmagic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebmagicApplicationTests {

	@Test
	public void contextLoads() {
		QueryVo vo = new QueryVo();
		vo.setPath("asdf");
		String s = new RestTemplate().postForEntity("localhost:7003/getallnodes", vo, String.class).getBody();
		System.out.println(s);
	}
	class QueryVo{
		private String path;

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
		
	}

}
