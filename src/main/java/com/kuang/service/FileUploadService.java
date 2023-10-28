package com.kuang.service;

import com.kuang.pojo.FilePath;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Autowired
    private PhotoCompressService photoCompressService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    public void fileUpload(CommonsMultipartFile file, HttpServletRequest request, String logid, String pathLocation) throws IOException {
        taskExecutor.execute(() -> {
            //上传路径保存设置
            //用了虛擬路徑，上傳位置需要填實際位置
            //String path = request.getServletContext().getRealPath(pathLocation);
            String path = "/usr/local/tomcat/webapps/erp" + pathLocation;
            System.out.println(file);
            File realPath = new File(path);
            if (!realPath.exists()){
                realPath.mkdir();
            }
            //上传文件地址
            System.out.println("上传文件保存地址："+realPath);

            //獲取副檔名
            String fileType = FilenameUtils.getExtension(file.getOriginalFilename());
            System.out.println("檔案類型"+fileType);
            if(fileType.equals("png") || fileType.equals("jpg") || fileType.equals("jpeg")){
                //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
                long fileSize = file.getSize();

                String filepath = pathLocation +"/"+ logid + "." + fileType;
                FilePath filePath = new FilePath(logid, filepath);

                int ifExist = vinService.ifExistFileTypebyID(logid);
                if(ifExist > 0){
                    vinService.updateFileType(filePath);
                }else {
                    vinService.addFileType(filePath);
                }

                try {
                    file.transferTo(new File(realPath +"/"+ logid + "." + fileType));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                photoCompressService.doCompressService(fileSize,realPath +"/"+ logid + "." + fileType);

            }else {
                System.out.println("上傳非圖片格式");
            }
        });




    }



}
