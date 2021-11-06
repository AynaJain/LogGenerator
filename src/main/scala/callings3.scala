import com.amazonaws.AmazonServiceException
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}
import com.amazonaws.regions.Regions
import com.typesafe.config.ConfigFactory

import java.io.File

object callings3:
  val config = ConfigFactory.load("application")
  val bucket_name: String = config.getString("s3utilities.s3bucket")
  val file_path: String = config.getString("s3utilities.file_path")
  val key_name: String = config.getString("s3utilities.key")

  val s3: AmazonS3 = AmazonS3ClientBuilder.standard.withRegion(Regions.US_EAST_1).build
  try s3.putObject(bucket_name, key_name, new File(file_path))

  catch {
    case e: AmazonServiceException =>
      System.err.println(e)
      System.exit(1)
  }
