package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import train.model.AjaxResponse;
import train.model.TicketGenerator;
import train.model.Train;
import train.model.User;
import train.service.TicketService;
import train.service.TicketSetService;
import train.service.TrainService;
import train.service.UserService;

@RestController
public class ManageController {


    @Autowired
    UserService userService;
    @Autowired
    TicketService ticketService;
    @Autowired
    TrainService trainService;
    @Autowired
    TicketSetService ticketSetService;


    @PostMapping("/admin/check")
    public AjaxResponse checkTicket(@RequestParam("username") String username,
                                    @RequestParam("token") String token,
                                    @RequestParam(value = "ticket_id", defaultValue = "-1") Integer ticket_id) {

        User user = userService.queryUser(username);
        if (!user.getCredit().equals("a")) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("您没有权限！")
                    .build();
        } else if (userService.confirmTokenByUsername(username, token) == null) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("失败！")
                    .build();
        }

        if (ticket_id == -1) {
            ticketService.checkTicketByTime();
            return AjaxResponse.builder()
                    .status("OK")
                    .msg("全局检票结束")
                    .build();
        } else {
            ticketService.checkTicketByTicketId(ticket_id);
            return AjaxResponse.builder()
                    .status("OK")
                    .msg("检票 #" + ticket_id.toString() + " 并检测订单状况")
                    .build();
        }

    }


    @PostMapping("/admin/train")
    public Train queryTrainByTrainCode(@RequestParam("train_code") String train_code) {
        return trainService.queryTrainByTrainCode(train_code);
    }


    @PostMapping("/admin/generateTest")
    public AjaxResponse generateTicketSetTest(@RequestBody TicketGenerator ticketGenerator) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("f28hj23no");
        return AjaxResponse.builder()
                .status("OK")
                .msg(ticketGenerator.getDate() + " NO票集已生成！")
                .build();
    }


    @PostMapping("/admin/generate")
    public AjaxResponse generateTicketSet(@RequestBody TicketGenerator ticketGenerator) {
        User user = userService.queryUser(ticketGenerator.getUsername());
        if (!user.getCredit().equals("a")) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("您没有权限！")
                    .build();
        } else if (userService.confirmTokenByUsername(ticketGenerator.getUsername(), ticketGenerator.getToken()) == null) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("失败！")
                    .build();
        }

        String response = ticketSetService.generateTicketSetWithConditions(ticketGenerator.getDate(), ticketGenerator.getStations());

        return AjaxResponse.builder()
                .status("OK")
                .msg(response.equals("OK") ? ticketGenerator.getDate() + "票集已生成！" : response)
                .build();
    }


    @PostMapping("/admin/addStation")
    public AjaxResponse addStation(@RequestParam("username") String username,
                                   @RequestParam("token") String token,
                                   @RequestParam("train_code") String train_code,
                                   @RequestParam("station_name") String station_name,
                                   @RequestParam("time") String time,
                                   @RequestParam(value = "arrive_day", defaultValue = "0") Integer arrive_day) {
        User user = userService.queryUser(username);
        if (!user.getCredit().equals("a")) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("您没有权限！")
                    .build();
        } else if (userService.confirmTokenByUsername(username, token) == null) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("失败！")
                    .build();
        }

        String response = trainService.addStation(train_code, station_name, time, arrive_day);
        return AjaxResponse.builder()
                .status("OK")
                .msg(response)
                .build();
    }


    @PostMapping("/admin/deleteStation")
    public AjaxResponse deleteStation(@RequestParam("username") String username,
                                      @RequestParam("token") String token,
                                      @RequestParam("train_code") String train_code,
                                      @RequestParam("station_name") String station_name) {
        User user = userService.queryUser(username);
        if (!user.getCredit().equals("a")) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("您没有权限！")
                    .build();
        } else if (userService.confirmTokenByUsername(username, token) == null) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("失败！")
                    .build();
        }

        String response = trainService.deleteStation(train_code, station_name);
        return AjaxResponse.builder()
                .status("OK")
                .msg(response)
                .build();
    }


    @PostMapping("/admin/assignCredit")
    public AjaxResponse assignCredit(@RequestParam("username") String username,
                                     @RequestParam("token") String token,
                                     @RequestParam("userToken") String userToken,
                                     @RequestParam("credit") String credit) {
        User user = userService.queryUser(username);
        if (!user.getCredit().equals("a")) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("您没有权限！")
                    .build();
        } else if (userService.confirmTokenByUsername(username, token) == null) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("失败！")
                    .build();
        }

        Integer recipientId = userService.getUserId(userToken);
        if (recipientId == null) {
            return AjaxResponse.builder()
                    .status("NO")
                    .msg("查无此人！")
                    .build();
        }

        userService.assignCreditByUserId(recipientId, credit);
        return AjaxResponse.builder()
                .status("OK")
                .msg("设置成功！")
                .build();
    }


}