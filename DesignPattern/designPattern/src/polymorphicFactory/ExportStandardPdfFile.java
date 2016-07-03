package polymorphicFactory;
public class ExportStandardPdfFile implements ExportFile {

    @Override
    public boolean export(String data) {

        System.out.println("导出标准PDF文件");
        return true;
    }

}