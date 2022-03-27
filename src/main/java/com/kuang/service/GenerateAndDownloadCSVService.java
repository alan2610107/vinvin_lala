package com.kuang.service;

import com.kuang.pojo.VinCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;


/**
 * @author Chi-Lin Wu
 * @apiNote Generate and download CSV file
 */
@Service
@Slf4j
public class GenerateAndDownloadCSVService {

    /**
     *
     * @param response
     * @param reportName
     * @param vinChecks
     * @throws IOException
     */
    public void downloadCSV(HttpServletResponse response, String reportName, List<VinCheck> vinChecks) throws IOException {
        System.out.println("=====Start!!=====");
        response.reset();
        response.setContentType("application/octet-stream; charset=UTF-8");
        response.setHeader("Content-Encoding", "UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(reportName, "UTF-8"));

        OutputStream outputStream = null;
        outputStream = response.getOutputStream();
        outputStream.write(0xEF);   // 1st byte of BOM
        outputStream.write(0xBB);
        outputStream.write(0xBF);   // last byte of BOM
        // now get a PrintWriter to stream the chars.


        PrintWriter os = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        StringBuffer sb = new StringBuffer();
        sb.append(";名字;品牌;日盤数量;實際数量;時間;狀態");
        sb.append("\n");
        for (int i = 0; i < vinChecks.size(); i++) {
            VinCheck vinCheck = vinChecks.get(i);
            int index = i + 1;
            String indexStr = index + ";";
            String itemname = vinCheck.getItemName() + ";";
            String brand = vinCheck.getBrand() + ";";
            String checkItemCount = vinCheck.getCheckitemCount() + ";";
            String realItemCount = vinCheck.getRealitemCount() + ";";
            String time = vinCheck.getTime() + ";";
            String difference;
            if (vinCheck.getIfmatch().equals("same")) {
                difference = "一樣";
            } else if (vinCheck.getIfmatch().equals("less")) {
                difference = "少了" + vinCheck.getDifference();
            } else {
                difference = "多了" + vinCheck.getDifference();
            }
            sb.append(indexStr + itemname + brand + checkItemCount + realItemCount + time + difference);
            if (i < vinChecks.size() - 1) {
                sb.append("\n");
            }

        }

        os.print(sb);
        os.flush();
        os.close();
        System.out.println("=====Finish!!=====");


    }
}
