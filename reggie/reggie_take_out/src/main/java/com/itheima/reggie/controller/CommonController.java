package com.itheima.reggie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itheima.reggie.common.R;

import lombok.extern.slf4j.Slf4j;

/**
 * ファイルのアップロードとダウンロード
 * 
 * @author dreammtank125
 *
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
	@Value("${reggie.path}")
	private String basePath;

	/**
	 * ファイルのアップロード
	 * 
	 * @param file
	 * @return
	 */

	@PostMapping("/upload")
	public R<String> uploaad(MultipartFile file) {
		log.info(file.toString());
		// fileは一時ファイルであり、特定の場所に保存しないと、このリクエストが完了した後、削除されます

		// 元のファイル名
		String originalFilename = file.getOriginalFilename();
		// 元のファイル名が重複してファイルを上書きするのを防ぐために、通常はUUIDを使用してファイル名を再生成します
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		String fileName = UUID.randomUUID().toString() + suffix;
		// ディレクトリオブジェクトを作成する
		File dir = new File(basePath);
		// 現在のディレクトリが存在するかどうかを判断する
		if (!dir.exists()) {
			// ディレクトリが存在しません、ディレクトリを作成する
			dir.mkdirs();
		}

		try {
			// 一時ファイルを特定の場所に保存する
			file.transferTo(new File(basePath + fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		return R.success(fileName);
	}

	/**
	 * ファイルのダウンロード
	 * 
	 * @param name
	 * @param response
	 */

	@GetMapping("/download")
	public void download(String name, HttpServletResponse response) {

		try {
			// 入力ストリームを使用してファイルの内容を読み取る
			FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
			response.setContentType("image/jpeg");

			// 出力ストリームを使用してファイルをブラウザに書き戻し、画像をブラウザで表示できるようにする。
			ServletOutputStream outputStream = response.getOutputStream();

			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = fileInputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, len);
				outputStream.flush();
			}
			outputStream.close();
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
