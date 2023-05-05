package org.example.Service;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface SimpleCrudI<Res,Req> {
    public ResponseEntity<Res> GetById( UUID Id);

    public ResponseEntity<String> Add(List<Req> request);

    public ResponseEntity<String> Update(Req request);

    public ResponseEntity<String> Delete(UUID Id);

    public ResponseEntity<List<Res>> Query();
}
