package inter.phone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

/* Dropbox telephonic interview question
input: a string path to a directory
example: '/foo'

output: a list of lists of duplicate files
example:
[
   ['/foo/bar.png', '/foo/images/foo.png'],
   ['/foo/file.tmp', '/foo/other.temp', '/foo/temp/baz/that.foo']
]
*/

public class FindDuplicateFiles {
	private List<List<Path>> findDuplicates(Path p) throws IOException, NoSuchAlgorithmException {
		Map<String, List<Path>> duplicates = new HashMap<>();
		dedup(p, duplicates);
		List<List<Path>> output = new ArrayList<>();
		for (List<Path> list : duplicates.values()) {
			output.add(list);
		}
		return output;
	}

	private void dedup(Path p, Map<String, List<Path>> duplicates) throws IOException, NoSuchAlgorithmException {
		if (Files.isRegularFile(p, LinkOption.NOFOLLOW_LINKS)) {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] digest = md.digest(Files.readAllBytes(p));
			String fingerPrint = DatatypeConverter.printHexBinary(digest);
			List<Path> duplicateFiles = null;
			if (duplicates.containsKey(fingerPrint)) {
				duplicateFiles = duplicates.get(fingerPrint);
			} else {
				duplicateFiles = new ArrayList<>();
			}
			duplicateFiles.add(p);
			duplicates.put(fingerPrint, duplicateFiles);
		}
		if (Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
			Files.list(p).forEach(x -> {
				try {
					dedup(x, duplicates);
				} catch (IOException | NoSuchAlgorithmException e) {
				}
			});
		}
	}

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		Path p = Paths.get("C:\\SampleDir");
		List<List<Path>> duplicates = new FindDuplicateFiles().findDuplicates(p);
		duplicates.forEach(x -> System.out.println(x));
	}
}

//import java.io.*;
//import java.util.*;
//
///* Dropbox telephonic interview question
//input: a string path to a directory
//example: '/foo'
//
//output: a list of lists of duplicate files
//example:
//  [
//     ['/foo/bar.png', '/foo/images/foo.png'],
//     ['/foo/file.tmp', '/foo/other.temp', '/foo/temp/baz/that.foo']
//  ]
// */
//
///*
//  /foo/bar.png
//  /foo/file.tmp
//  /foo/images/foo.png  // same as bar.png
//  
//*/
//
//ArrayList<String> listDir(String rootPath);  // Returns direct children; similar to `ls` in terminal
//boolean isDir(String path);
//
//
//class Solution {
//  
//  Map<String, List<String>> dedupList = new HashMap<>();
//  String generateHash(String filePath) {
//    File f = new File(path);
//    if(f.isFile()) {
//      // generate hash and return it
//    }
//  }
//  
//  String fastHash(String filePath) {
//    // O(1)
//    // Properties: if (fastHash(A) != fastHash(B)) => A != B
//  }
//
//  public List<List<String>> dedup(String directoryPath) {
//    Map<String, List<String>> dedupMap = dedupHelper(directoryPath);
//    List<List<String>> returnList = new ArrayList<>();
//    for(List<String> filesList : dedupMap.values()) {
//      returnList.add(filesList);
//    }
//    return returnList;
//  }
//  
//  private void dedupHelper(String directoryPath) {
//    if(isDir(directoryPath)) {
//      List<String> paths = listDir(directoryPath);
//      for(String path : paths) {
//        if(isDir(path)) {
//          dedupHelper(path)
//        }
//        else {
//          // compute magicHash and store it in the dedupList
//          String magicHash = generateHash(path);
//          if(dedupList.containsKey(magicHash)) {
//            List<String> filesList = dedupList.get(magicHash);
//            filesList.add(path);
//            dedupList.put(magicHash, filesList);
//          }
//          else {
//            List<String> filesList = new ArrayList<>();
//            filesList.add(path);
//            dedupList.put(magicHash, filesList);
//          }
//        }   // dedupList = hash1 : [bar.png, foo.png], hash2 : [file.tmp]
//      }
//      
//    }
//    else {
//      String magicHash = generateHash(directoryPath);
//      List<String> filesList = new ArrayList<>();
//      filesList.add(magicHash);
//      dedupList.put(magicHash, filesList);
//    }
//  
//  }
//
//  public static void main(String[] args) {
//    ArrayList<String> strings = new ArrayList<String>();
//    strings.add("Hello, World!");
//    strings.add("Welcome to CoderPad.");
//    strings.add("This pad is running Java 8.");
//
//    for (String string : strings) {
//      System.out.println(string);
//    }
//  }
//}
