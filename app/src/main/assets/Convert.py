import os
import json

def convert_cah_to_json(directory):
    """
    Converts all .cah files to .json files within a directory and its subfolders.

    Args:
        directory (str): The path to the directory to scan.
    """
    for root, _, files in os.walk(directory):
        for filename in files:
            if filename.endswith(".cah"):
                cah_filepath = os.path.join(root, filename)
                json_filepath = os.path.splitext(cah_filepath)[0] + ".json"

                try:
                    with open(cah_filepath, 'r') as cah_file:
                        # Attempt to load the cah file as JSON. If it's not valid json,
                        # it will throw a json.JSONDecodeError, and the file will be skipped.
                        data = json.load(cah_file)

                    with open(json_filepath, 'w') as json_file:
                        json.dump(data, json_file, indent=4) # indent for readability

                    os.remove(cah_filepath) # Optionally remove original .cah file

                    print(f"Converted: {cah_filepath} -> {json_filepath}")

                except json.JSONDecodeError:
                    print(f"Error: {cah_filepath} is not valid JSON. Skipping.")
                except Exception as e:
                    print(f"Error processing {cah_filepath}: {e}")

if __name__ == "__main__":
    # directory_to_scan = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets"
    directory_to_scan = "/workspaces/capstoneproject-e5-studios/app/src/main/assets"
    if os.path.exists(directory_to_scan):
        convert_cah_to_json(directory_to_scan)
    else:
        print(f"Error: Directory '{directory_to_scan}' not found.")