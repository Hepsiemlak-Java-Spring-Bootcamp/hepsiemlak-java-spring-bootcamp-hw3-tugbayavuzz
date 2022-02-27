package emlakburada.controller;

import emlakburada.model.dto.Advert;
import emlakburada.model.request.AdvertRequest;
import emlakburada.model.response.AdvertResponse;
import emlakburada.service.AdvertService;
import emlakburada.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;
    private final UserService userService;

    @GetMapping(value = "/adverts")
    public ResponseEntity<List<AdvertResponse>> getAllAdvert() {
        return new ResponseEntity<>(advertService.getAllAdverts(), HttpStatus.OK);
    }

    @PostMapping(value = "/adverts")
    public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest request) {
        return new ResponseEntity<>(advertService.saveAdvert(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/adverts/{advertNo}")
    public ResponseEntity<AdvertResponse> getAdvertByAdvertId(@PathVariable(required = false) int advertNo) {
        return ResponseEntity.ok(advertService.getAdvertByAdvertId(advertNo));
    }

    @GetMapping(value = "/adverts/{userId}")
    public ResponseEntity<Set<Advert>> findFavouriteAdvertsByUserId(@PathVariable(required = false) Long userId) {
        return ResponseEntity.ok(userService.findFavouriteAdvertsByUserId(userId));
    }

}
