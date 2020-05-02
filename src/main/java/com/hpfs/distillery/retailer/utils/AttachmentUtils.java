package com.hpfs.distillery.retailer.utils;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.springframework.util.StringUtils;

public class AttachmentUtils {

	
	public static byte[] compress(String data) throws IOException {
		if (StringUtils.isEmpty(data))
            return null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getBytes());
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        return compressed;
	}

	public static String decompress(byte[] compressed) throws IOException {
		if (compressed == null || compressed.length < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();;
        try {
			ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
			BufferedReader br = null;
			if(isGzipStream(compressed)) {
				GZIPInputStream gis = new GZIPInputStream(bis);
				br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
				sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				gis.close();
				bis.close();
			}else {
				br = new BufferedReader(new InputStreamReader(bis, "UTF-8"));
				sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				bis.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	

	public static boolean isGzipStream(byte[] bytes) {
	      int head = ((int) bytes[0] & 0xff) | ((bytes[1] << 8) & 0xff00);
	      return (GZIPInputStream.GZIP_MAGIC == head);
	}
	
}
