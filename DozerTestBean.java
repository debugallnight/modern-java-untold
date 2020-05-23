import java.io.IOException;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@TestConfiguration
public class DozerTestBean {
	
	@Bean(name = "dozerBean")
	@Scope("singleton")
	public DozerBeanMapperFactoryBean configDozer() throws IOException {

		final DozerBeanMapperFactoryBean mapperBean = new DozerBeanMapperFactoryBean();
		
		final Resource[] resources = new PathMatchingResourcePatternResolver()
				.getResources("classpath*:dozer-mappings-test.xml");
		mapperBean.setMappingFiles(resources);

		return mapperBean;
	}

}
