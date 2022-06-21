package projecta07.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projecta07.service.IIncomeService;
import java.util.Optional;

@RequestMapping("/manager/api/income")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class IncomeController {
    @Autowired
    private IIncomeService iIncomeService;

    // Author: ToanPT

    // THEO NGÀY
    @GetMapping("/day")
    public ResponseEntity incomeToDay(Model model) {
        model.addAttribute("sumTotalDay", iIncomeService.sumTotalOderDay());
        double totalDay = Double.parseDouble(iIncomeService.sumTotalOderDay());
        return new ResponseEntity(totalDay, HttpStatus.OK);
    }

    // THEO TUẦN
    @GetMapping("/week")
    public ResponseEntity incomeToWeek(Model model) {
        model.addAttribute("sumTotalWeek", iIncomeService.sumTotalOrderWeek());
        double totalWeek = Double.parseDouble(iIncomeService.sumTotalOrderWeek());
        return new ResponseEntity(totalWeek, HttpStatus.OK);
    }

    // THEO THÁNG
    @GetMapping("/month")
    public ResponseEntity incomeToMonth(Model model) {
        model.addAttribute("sumTotalMonth", iIncomeService.sumTotalOrderWeek());
        double totalMonth = Double.parseDouble(iIncomeService.sumTotalOrderMonth());
        return new ResponseEntity(totalMonth, HttpStatus.OK);
    }

    // THEO NĂM
    @GetMapping("/year")
    public ResponseEntity incomeToYear(Model model) {
        model.addAttribute("sumTotalYear", iIncomeService.sumTotalOrderWeek());
        double totalYear = Double.parseDouble(iIncomeService.sumTontalOrderYear());
        return new ResponseEntity(totalYear, HttpStatus.OK);
    }

    // TỪ NGÀY NÀY ĐẾN NGÀY KHÁC C1
//    @GetMapping("/daytoday/{startDay}/{endDay}")
//    public ResponseEntity incomeDayToDay(@PathVariable String startDay, @PathVariable String endDay) {
//        double totalDayToDay = Double.parseDouble(iIncomeService.sumTotalStartDayToEndDay(startDay, endDay));
//        return new ResponseEntity(totalDayToDay, HttpStatus.OK);
//    }


    // TỪ NGÀY NÀY ĐẾN NGÀY KHÁC C2
    @GetMapping("/daytoday")
    public ResponseEntity incomeDayToDay(@RequestParam(value = "startDay", required = false) Optional<String> startDay,
                                         @RequestParam(value = "endDay", required = false) Optional<String> endDay){
        System.out.println(startDay.get() + " - "+ endDay.get());
        double totalDayToDay = 0;
        if (startDay.isPresent() && endDay.isPresent()){
             totalDayToDay = Double.parseDouble(iIncomeService.sumTotalStartDayToEndDay(startDay.get(), endDay.get()));
        }
        return new ResponseEntity(totalDayToDay, HttpStatus.OK);
    }
}
