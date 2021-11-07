//import com.amazonaws.AmazonServiceException
//import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}
//import com.amazonaws.regions.Regions
//import com.typesafe.config.ConfigFactory
//
//import java.io.File
//
////Reference: https://codedestine.com/aws-s3-putobject-java/
////Reference: https://stackoverflow.com/questions/42230086/writing-a-file-into-amazon-s3-aws-storage-using-scala
//
//object callings3:
//  val config = ConfigFactory.load("application")
//  val bucketName: String = config.getString("s3utilities.s3bucket")
//  val filePath: String = config.getString("s3utilities.file_path")
//  val fileName: String = config.getString("s3utilities.key")
//
//  val s3: AmazonS3 = AmazonS3ClientBuilder.standard.withRegion(Regions.US_EAST_1).build
//  try s3.putObject(bucketName, filePath, new File(fileName))
//
//  catch {
//    case e: AmazonServiceException =>
//      System.err.println(e)
//      System.exit(1)
//  }