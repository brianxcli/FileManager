package brian.com.filemanager.utils;

import java.io.File;

import brian.com.filemanager.R;

public class FileUtils {
    public static class FileInfo {
        public String name;
        public String path;
        public FileType type;
        public boolean isDirectory;
        public long lastModified;
        public int iconRes;

        public FileInfo() {

        }

        public FileInfo(File file) {
            name = file.getName();
            path = file.getParent();
            isDirectory = file.isDirectory();
            type = getType(name, isDirectory);
            lastModified = file.lastModified();
            iconRes = getIconRes(type);
        }

        public static FileType getType(String name, boolean isDir) {
            String n = name.toLowerCase();
            if (isDir) {
                return FileType.DIR;
            } else if (n.endsWith(".zip") || n.endsWith(".rar")) {
                return FileType.ZIP;
            } else if (n.endsWith(".apk")) {
                return FileType.APK;
            } else if (n.endsWith(".mp3")) {
                return FileType.MUSIC;
            } else if (n.endsWith(".mp4")) {
                return FileType.VIDEO;
            } else if (n.endsWith(".jpg") || n.endsWith(".png")) {
                return FileType.PIC;
            } else if (n.endsWith(".doc")) {
                return FileType.DOC;
            } else if (n.endsWith(".pdf")) {
                return FileType.PDF;
            } else if (n.endsWith(".ppt")) {
                return FileType.PPT;
            } else if (n.endsWith(".txt")) {
                return FileType.TXT;
            } else if (n.endsWith(".xls")) {
                return FileType.XLS;
            } else {
                return FileType.OTHER;
            }
        }

        public static int getIconRes(FileType type) {
            switch (type) {
                case ZIP:
                    return R.drawable.file_zip_unselect;
                case APK:
                    return R.drawable.file_apk_unselect;
                case MUSIC:
                    return R.drawable.file_music_unselect;
                case VIDEO:
                    return R.drawable.file_video_unselect;
                case PIC:
                    return R.drawable.file_pic_unselect;
                case DOC:
                    return R.drawable.file_doc_unselect;
                case PDF:
                    return R.drawable.file_pdf_unselect;
                case PPT:
                    return R.drawable.file_ppt_unselect;
                case TXT:
                    return R.drawable.file_txt_unselect;
                case UMD:
                    return R.drawable.file_umd_unselect;
                case XLS:
                    return R.drawable.file_xls_unselect;
                case DIR:
                    return R.drawable.folder_unselect;
                case OTHER:
                    return R.drawable.file_other_unselect;
                default:
                    return -1;
            }
        }
    }

    public enum FileType {
        ZIP, APK, MUSIC, VIDEO, PIC, DOC, PDF, PPT, TXT, UMD, XLS, DIR, OTHER
    }
}
