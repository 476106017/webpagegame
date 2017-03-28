package zdm.fate.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("zdm.fate.domain.repository")
public class WebAppConfig {
	// @Bean
	// public EmbeddedServletContainerFactory servletContainerFactory() {
	// TomcatEmbeddedServletContainerFactory factory = new
	// TomcatEmbeddedServletContainerFactory() {
	// @Override
	// protected void postProcessContext(Context context) {
	// // SecurityConstraint������ڣ�����ͨ����Ϊ��ͬ��URL���ò�ͬ���ض�����ԡ�
	// SecurityConstraint securityConstraint = new SecurityConstraint();
	// securityConstraint.setUserConstraint("CONFIDENTIAL");
	// SecurityCollection collection = new SecurityCollection();
	// collection.addPattern("/*");
	// securityConstraint.addCollection(collection);
	// context.addConstraint(securityConstraint);
	// }
	// };
	// factory.addAdditionalTomcatConnectors(createHttpConnector());
	// return factory;
	// }
	//
	// private Connector createHttpConnector() {
	// Connector connector = new Connector(
	// "org.apache.coyote.http11.Http11NioProtocol");
	// connector.setScheme("http");
	// connector.setSecure(false);
	// connector.setPort(8080);
	// connector.setRedirectPort(8012);
	// return connector;
	// }
}
