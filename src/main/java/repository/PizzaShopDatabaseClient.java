package repository;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class PizzaShopDatabaseClient {
	private static Cluster cluster;
	private static Session session;

	public static Session getSession() {
		if (session == null) {
			session = createSession();
		}
		return session;
	}
	
	protected static Session createSession() {
		Cluster cluster = Cluster.builder().addContactPoint("172.17.0.3").build();
		Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
					host.getDatacenter(), host.getAddress(), host.getRack());
		}
		return cluster.connect();
	}
	
	public void close() {
		cluster.close();
	}
}
