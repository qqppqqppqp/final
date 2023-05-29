package org.zerock.seoulive.board.travel.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.travel.domain.DTO;
import org.zerock.seoulive.board.travel.domain.VO;
<<<<<<< HEAD
import org.zerock.seoulive.board.travel.exception.ControllerException;
import org.zerock.seoulive.board.travel.service.Service;
=======
import org.zerock.seoulive.board.travel.service.service;
import org.zerock.seoulive.exception.ControllerException;
>>>>>>> origin

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Log4j2
@NoArgsConstructor
@Controller
@RequestMapping("/board/travel/*")
public class TravelController {

    @Setter(onMethod_ = {@Autowired})
    private Service service;

//    @GetMapping("/list")
//    void list(Model model) throws ControllerException {
//
//        try {
//            List<VO> list = this.service.getList();
//
//            // Request Scope 공유속성 생성
//            model.addAttribute("__LIST__", list);
//        } catch(Exception e) {
//            throw new ControllerException(e);
//        } // try-catch
//    } // list

    @PostMapping(value = "/write")
    String write(DTO dto, RedirectAttributes rttrs) throws ControllerException {

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

        try {
            Objects.requireNonNull(dto);

            if(this.service.register(dto)) {
                rttrs.addFlashAttribute("result", true);
                rttrs.addFlashAttribute("seq", dto.getSeq());
            } // end if
            return "redirect:/board/travel/list";
        }
        catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    }

    @GetMapping("/write")
    void write() {	// 단순 수정 화면 요청

    } //

    @GetMapping(path = "/view", params = "seq")
    void view(@RequestParam("seq") Integer seq, Model model) throws ControllerException {

        try {
            VO vo = this.service.get(seq);
            model.addAttribute("__BOARD__", vo);
        }
        catch (Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // view

    @PostMapping("/modify")
    String modify(DTO dto, RedirectAttributes rttrs) throws ControllerException {
        log.info("modify({}, {}) invoked.", dto, rttrs);
        try {
            Objects.requireNonNull(dto);

            Boolean result = this.service.modify(dto);
                rttrs.addAttribute("result", result);
                rttrs.addAttribute("seq", dto.getSeq());
//                if(this.service.modify(dto)) {
//                    rttrs.addAttribute("result", "true");
//                    rttrs.addAttribute("seq", dto.getSeq());
//                } // end if

                return "redirect:/board/travel/modify";
        }
        catch (Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // modify

    @GetMapping("/modify")
    void modify(Integer seq, Model model) throws ControllerException {	// 단순 수정 화면 요청

        try {
           VO vo = this.service.get(seq);
           model.addAttribute("__BOARD__", vo);

        }
        catch (Exception e) {
            throw new ControllerException(e);
        }
    } //

    @PostMapping("/remove")
    String remove(Integer seq, RedirectAttributes rttrs) throws ControllerException {

        try {
//            rttrs.addAttribute("currPage", currPage);

            Boolean result = this.service.remove(seq);
                rttrs.addAttribute("result", result);
                rttrs.addAttribute("seq", seq);
//            if (this.service.remove(seq)) {
//                rttrs.addAttribute("result", true);
//                rttrs.addAttribute("seq", seq);
//            } // end if

            return "redirect:/board/travel/list";
        }
        catch (Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // remove
}
