package org.zerock.seoulive.board.course.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.seoulive.board.course.domain.Criteria;
import org.zerock.seoulive.board.course.domain.commDTO;
import org.zerock.seoulive.board.course.domain.commVO;
import org.zerock.seoulive.board.course.service.commService;

import javax.print.attribute.standard.Media;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RequestMapping("/replies/")
@Log4j2

@Controller
@AllArgsConstructor
public class commentController {
    private commService service;


    //등록
    @PostMapping(value="/new/{board_name}", consumes = "application/json",produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@PathVariable("board_name") @RequestBody commVO vo) throws Exception {
        log.trace("create() invoked");

        try {
            log.info("commVO: {}" , vo);

            commDTO dto = vo.toDTO();
            Date currentDate = new Date();
            log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  currentDate: {}", currentDate);
            dto.setWRITE_DATE(currentDate);

            vo.setBOARD_NAME(dto.getBoard_name());

            Integer insertCount = service.write(vo);
            log.info("reply insert count: ", insertCount);



            return insertCount ==1 ? new ResponseEntity<>("success", HttpStatus.OK)
                    :new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.info("Error occurred during create: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }


    //특정 게시물 댓글 목록
    @GetMapping(value= "/pages/{board_name}/{page}",
    produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<commVO>> getList(
            @PathVariable("page") int page,
            @PathVariable("board_name") String board_name,
            commVO vo,Model model) throws Exception {
        log.trace("getList() invoked");

        Criteria cri = new Criteria(page, board_name);
        model.addAttribute("__COMMENT__", vo);
        log.info("cri");

        return new ResponseEntity<>(service.list(cri, board_name), HttpStatus.OK);

    }

    @GetMapping(params = {"seq"},
    produces = {
            MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> remove(@PathVariable("seq")Integer seq) throws Exception {
        log.info("remove() invoked");

        return service.delete(seq) ==1
                ?new ResponseEntity<>("success", HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
    value="/{seq}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(
            @RequestBody commVO vo,
            @PathVariable("seq") Integer seq
    ) throws Exception {
        vo.setSEQ(seq);

        log.info("seq: {}", seq);
        log.info("modify: {}", vo);

        return service.modify(vo) ==1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
