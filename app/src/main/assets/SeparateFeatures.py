import json
import os

def extract_features_to_files(input_directory, output_directory):
    """
    Extracts features from JSON files in an input directory and saves each feature
    to its own JSON file in the specified output directory.

    Args:
        input_directory (str): The directory containing the JSON files.
        output_directory (str): The directory to save the feature files.
    """

    os.makedirs(output_directory, exist_ok=True) #create output directory if it doesn't exist

    for filename in os.listdir(input_directory):
        if filename.endswith(".json"):
            filepath = os.path.join(input_directory, filename)
            try:
                with open(filepath, "r") as f:
                    data = json.load(f)

                if "features" in data and isinstance(data["features"], list):
                    features = data["features"]
                    for feature_container in features:
                        if isinstance(feature_container, dict) and "feat" in feature_container:
                            feature = feature_container["feat"]
                            if isinstance(feature, dict) and "name" in feature:
                                feature_name = feature["name"].replace(" ", "").replace("/", "")
                                feature_filename = f"{feature_name}.json"
                                feature_filepath = os.path.join(output_directory, feature_filename)
                                with open(feature_filepath, "w") as feature_file:
                                    json.dump(feature, feature_file, indent=4)
                            else:
                                print(f"Warning: Invalid feature format in {filename}: {feature}")
                        else:
                            print(f"Warning: Invalid feature container format in {filename}: {feature_container}")

            except FileNotFoundError:
                print(f"Error: File not found: {filepath}")
            except json.JSONDecodeError:
                print(f"Error: Invalid JSON format in {filepath}")
            except Exception as e:
                print(f"An unexpected error occurred while processing {filepath}: {e}")

# Example usage:
input_directory_path = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets/dndclasses"  # Replace with the actual input directory path
output_directory_path = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets/features" #Raw string to avoid escape sequence issues.

extract_features_to_files(input_directory_path, output_directory_path)