package org.Tayana.GRPC_server_Project.client;

import com.example.service.EmployServiceGrpc;
import com.example.service.EmployeRequest;
import com.example.service.EmployeResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;

public class EmployeClient {

    @GrpcClient("EmployService")
    private EmployServiceGrpc.EmployServiceBlockingStub blockingStub;
    public static void main(String[] args) {
        String address = "localhost";
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, 8081)
                .usePlaintext()
                .build();

        EmployServiceGrpc.EmployServiceBlockingStub blockingStub = EmployServiceGrpc.newBlockingStub(channel);

        EmployeRequest employeRequest = EmployeRequest.newBuilder()
                .setId(18)
                .setName("virat kohli")
                .build();

        EmployeResponse employeResponse =blockingStub.getEmployId(employeRequest);
        System.out.println("=============");
        // Print the response
        System.out.println("Response: " + employeResponse.getMessage());
    }
}
