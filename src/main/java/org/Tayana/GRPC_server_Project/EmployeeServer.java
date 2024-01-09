package org.Tayana.GRPC_server_Project;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class EmployeeServer
{
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server=ServerBuilder
				.forPort(8081)
				.addService(new EmployeService()).build();
		System.out.println("server started");
		server.start();
		server.awaitTermination();
	}

}
