package org.Tayana.GRPC_server_Project;

import com.example.service.EmployServiceGrpc.EmployServiceImplBase;
import com.example.service.EmployeRequest;
import com.example.service.EmployeResponse;

import io.grpc.stub.StreamObserver;

//@GrpcService
public class EmployeService extends EmployServiceImplBase
{

	@Override
	public void getEmployId(EmployeRequest request, 
							StreamObserver<EmployeResponse> responseObserver)
	{
		EmployeResponse  employeResponse=EmployeResponse.newBuilder()
				.setMessage("response "+request.getId()+request.getName())
				.build();
		System.out.println("response "+request.getId());
		responseObserver.onNext(employeResponse);
		responseObserver.onCompleted();
	}


}
