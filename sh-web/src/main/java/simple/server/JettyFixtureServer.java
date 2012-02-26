package simple.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyFixtureServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server jettyServer = null;
		try {
			jettyServer = new Server();

			SocketConnector conn = new SocketConnector();
			conn.setPort(9999);
			jettyServer.setConnectors(new Connector[] { conn });

			WebAppContext webAppContext = new WebAppContext();
			webAppContext.setContextPath("/sh-web");
			webAppContext.setWar("src/main/webapp");
			jettyServer.setHandler(webAppContext);

			jettyServer.start();
		} catch (Exception e) {
			System.out.println("Could not start the Jetty server: " + e);
			if (jettyServer != null) {
				try {
					jettyServer.stop();
				} catch (Exception e1) {
					System.out
							.println("Unable to stop the jetty server: " + e1);
				}
			}
		}

	}

}
